CREATE TABLE authorities(
authorities_id BIGSERIAL NOT NULL PRIMARY KEY,
app_user_id BIGSERIAL NOT NULL,
authority VARCHAR NOT NULL,
CONSTRAINT app_user_fk foreign key (app_user_id) REFERENCES app_user(id)
);