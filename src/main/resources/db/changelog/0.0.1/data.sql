INSERT INTO roles(named) VALUES ('ROLE_USER');
INSERT INTO roles(named) VALUES ('ROLE_ADMIN');

INSERT INTO  users(roles_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from roles where named = 'ROLE_ADMIN'), 'admin', '$2a$10$FjzcBqLsoRzHKwA97W6yb./k6uVJIh4okTj0Z1ce7SwowUwQj7SJu', 'admin', 'admin', 'admin@mail.ru', '123123');

INSERT INTO users(roles_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from roles where named = 'ROLE_USER'), 'test', '$2a$10$vYLfdQHK9VYcPXLpmFjU5eHwbIK7BAfavjjsN4ZSFJAakHeDtBzxG', 'test', 'test', 'test@mail.ru', '123123');