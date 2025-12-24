CREATE TABLE IF NOT EXISTS country (
    country_id SERIAL PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    country_id SERIAL REFERENCES country(country_id)
);

CREATE TABLE IF NOT EXISTS genres (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author_id SERIAL REFERENCES authors(author_id),
    genre_id SERIAL REFERENCES genres(genre_id),
    publication_year INTEGER CHECK ( publication_year BETWEEN 0 AND EXTRACT(YEAR FROM CURRENT_DATE)),
    available_copies INT CHECK ( available_copies >= 0 ),
    total_copies INT CHECK ( total_copies >= 0 )
);

CREATE TABLE IF NOT EXISTS readers (
    reader_id SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    birth_date DATE CHECK (birth_date <= CURRENT_DATE),
    email TEXT NOT NULL UNIQUE,
    registration_date DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS loans (
    loan_id SERIAL PRIMARY KEY,
    book_id SERIAL REFERENCES books(book_id) ON DELETE CASCADE,
    reader_id SERIAL REFERENCES readers(reader_id) ON DELETE CASCADE,
    loan_date DATE NOT NULL DEFAULT CURRENT_DATE,
    due_date DATE NOT NULL DEFAULT CURRENT_DATE + INTERVAL '1 month',
    return_date DATE DEFAULT NULL
);