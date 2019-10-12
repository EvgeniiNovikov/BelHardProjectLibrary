
insert into author (name, birth_date) values ('Михаил Булгаков', '1891-05-15');
insert into author (name, birth_date) values ('Бенгтссон Франц', '1894-10-04');
insert into author (name, birth_date) values ('Станислав Лем', '1921-09-12');
insert into author (name, birth_date) values ('Фридрих Ницше', '1844-10-15');

insert into genre (name) value ('FANTASY');
insert into genre (name) value ('NOVEL');
insert into genre (name) value ('ACTION');
insert into genre (name) value ('SCIENCE');
insert into genre (name) value ('PHILOSOPHY');

insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (1, 'Мастер и Маргарита', 1, '978-5-699-60694-8', '1940-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (1, 'Театральный роман', 2, '5-17-015967-6', '1965-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (2, 'Рыжий Орм. Путь викинга', 3, '978-5-4438-0559-7', '1941-01-01');
insert book (author_id, book_name, genre_id, isbn, print_date)
    values (2, 'Викинги', 3, '5-85686-005-5', '1993-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (3, 'Мир на земле', 4, '5-01-002517-5', '1984-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (3, 'Магелланово облако', 4, '978-5-17-063600-6', '1955-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (4, 'Так говорил Заратустра.', 5, '978-5-17-107151-6', '1883-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (4, 'По ту сторону добра и зла.', 5, '978-5-17-107198-1', '1886-01-01');
insert into book (author_id, book_name, genre_id, isbn, print_date)
    values (4, 'Ecce Homo.', 5, '978-966-03-4962-9', '1888-01-01');




