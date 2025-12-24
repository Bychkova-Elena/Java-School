/* Найти все книги, опубликованные после 1900 года, отсортировать по году публикации (сначала новые) */
SELECT * FROM books
WHERE publication_year > 1900
ORDER BY publication_year DESC;

/* Найти читателей, зарегистрированных после 2019 года */
SELECT name FROM readers
WHERE EXTRACT(YEAR FROM registration_date) >= 2020
ORDER BY name;

/* Посчитать количество книг у каждого автора */
SELECT authors.name, COUNT(*) AS book_count FROM books
JOIN authors ON books.author_id = authors.author_id
GROUP BY authors.name
ORDER BY authors.name;

/* Найти среднее количество доступных копий книг по жанрам, оставить жанры, где количество доступных книг > 1 */
SELECT genres.genre_name, AVG(books.available_copies) FROM books
JOIN genres ON books.genre_id = genres.genre_id
GROUP BY genres.genre_name
HAVING AVG(books.available_copies) > 1;

/* Для каждого читателя посчитать:
   - Общее количество взятых книг
   - Количество возвращенных книг
   - Количество просроченных книг */
SELECT readers.name,
       COUNT(*) as count_loans,
       COUNT(return_date) as count_returning_book,
       COUNT(CASE
           WHEN loans.return_date IS NULL AND loans.due_date < CURRENT_DATE
               THEN 1
           END) as overdue_books
FROM loans
JOIN readers ON loans.reader_id = readers.reader_id
GROUP BY readers.reader_id, readers.name
ORDER BY readers.name;

/* Показать список всех книг с именами их авторов и названиями жанров, отсортировать по book_name */
SELECT books.title, a.name, g.genre_name FROM books
JOIN public.authors a on a.author_id = books.author_id
JOIN public.genres g on g.genre_id = books.genre_id
ORDER BY books.title;

/* Показать историю выдач с информацией о читателях и книгах */
SELECT readers.name, books.title, loans.loan_date, loans.due_date, loans.return_date FROM loans
JOIN books on books.book_id = loans.book_id
JOIN readers on readers.reader_id = loans.reader_id
ORDER BY readers.name;

/* Найти все книги определенного автора с указанием их жанров */
SELECT a.name, books.title, g.genre_name FROM books
JOIN public.authors a on a.author_id = books.author_id
JOIN public.genres g on g.genre_id = books.genre_id
WHERE a.name = 'Лев Николаевич Толстой';

/* Увеличить количество доступных копий (available_copies и total_copies) для всех книг определенного жанра */
UPDATE books
SET available_copies = available_copies + 1, total_copies = total_copies + 1
WHERE genre_id = 1;

/* Обновить return_date для читателя 1 и книги 1 */
UPDATE loans
SET return_date = current_date
WHERE reader_id = 1 AND book_id = 1;

/* Удалить жанр, у которого нет книг */
DELETE FROM genres WHERE NOT exists(SELECT * FROM books WHERE books.genre_id = genres.genre_id);

/* Удалить читателя, у которого нет активных выдач и который не брал книги более года */
DELETE FROM readers
WHERE
    NOT EXISTS (
        SELECT 1 FROM loans
        WHERE loans.reader_id = readers.reader_id
          AND return_date IS NULL
    )
  AND NOT EXISTS (
    SELECT 1 FROM loans
    WHERE loans.reader_id = readers.reader_id
      AND loan_date > CURRENT_DATE - INTERVAL '1 year'
);