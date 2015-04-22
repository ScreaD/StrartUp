CREATE DATABASE kickstarter_db
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

DROP TABLE projects;
DROP TABLE categories;

CREATE TABLE categories (
    id bigint NOT NULL,
    name text NOT NULL
);

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;

CREATE TABLE projects (
    id bigint NOT NULL,
    category_id bigint NOT NULL,
    name text NOT NULL,
    description text,
    money_need integer,
    money_has integer,
    days_left integer,
    history text,
    video_link text,
    question text
);

CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE projects_id_seq OWNED BY projects.id;

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);

ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq'::regclass);

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);
	
INSERT INTO categories (name) VALUES 
	('Sport'),
	('Science'),
	('Music');

	
INSERT INTO projects(
        category_id, name, description, money_need, money_has, days_left, 
        history, video_link, question)
VALUES (1, 'name for cat 1', 'descr', 0, 0, 0, 
        '', '', '');

            
INSERT INTO projects(
    category_id, name, description, money_need, money_has, days_left, 
    history, video_link, question)
VALUES (1, 'name 2 for cat 1', 'descr', 0, 0, 0, 
    '', '', '');

    
INSERT INTO projects(
        category_id, name, description, money_need, money_has, days_left, 
        history, video_link, question)
VALUES (2, 'name for cat 2', 'descr', 0, 0, 0, 
        '', '', '');

   
