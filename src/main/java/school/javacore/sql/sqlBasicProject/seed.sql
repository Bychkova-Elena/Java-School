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



