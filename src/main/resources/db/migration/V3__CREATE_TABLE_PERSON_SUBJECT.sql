CREATE TABLE IF NOT EXISTS PERSON_SUBJECT
(
    id SERIAL PRIMARY KEY,
    subject_id INTEGER REFERENCES SUBJECT (id),
    person_id INTEGER REFERENCES PERSON (id)
);