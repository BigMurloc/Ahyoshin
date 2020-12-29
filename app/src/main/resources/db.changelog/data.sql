INSERT INTO app_user (id, password, username)
VALUES (1, 'password', 'admin');

INSERT INTO authority (authority, id)
VALUES ('admin', 1);

ALTER SEQUENCE hibernate_sequence RESTART WITH 2;
