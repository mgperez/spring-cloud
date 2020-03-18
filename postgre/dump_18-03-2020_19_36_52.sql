--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases (except postgres and template1)
--

DROP DATABASE statistics;




--
-- Drop roles
--

DROP ROLE sarah;


--
-- Roles
--

CREATE ROLE sarah;
ALTER ROLE sarah WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md59cdad2b42571221890a007631454b11f';






--
-- Databases
--

--
-- Database "template1" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2 (Debian 12.2-2.pgdg100+1)
-- Dumped by pg_dump version 12.2 (Debian 12.2-2.pgdg100+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

UPDATE pg_catalog.pg_database SET datistemplate = false WHERE datname = 'template1';
DROP DATABASE template1;
--
-- Name: template1; Type: DATABASE; Schema: -; Owner: sarah
--

CREATE DATABASE template1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8';


ALTER DATABASE template1 OWNER TO sarah;

\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: sarah
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: template1; Type: DATABASE PROPERTIES; Schema: -; Owner: sarah
--

ALTER DATABASE template1 IS_TEMPLATE = true;


\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: ACL; Schema: -; Owner: sarah
--

REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2 (Debian 12.2-2.pgdg100+1)
-- Dumped by pg_dump version 12.2 (Debian 12.2-2.pgdg100+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: sarah
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO sarah;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: sarah
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- PostgreSQL database dump complete
--

--
-- Database "statistics" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2 (Debian 12.2-2.pgdg100+1)
-- Dumped by pg_dump version 12.2 (Debian 12.2-2.pgdg100+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: statistics; Type: DATABASE; Schema: -; Owner: sarah
--

CREATE DATABASE statistics WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8';


ALTER DATABASE statistics OWNER TO sarah;

\connect statistics

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: sarah
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO sarah;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: passengerstiming; Type: TABLE; Schema: public; Owner: sarah
--

CREATE TABLE public.passengerstiming (
    id bigint NOT NULL,
    xlabel character varying(255),
    yvalue real NOT NULL
);


ALTER TABLE public.passengerstiming OWNER TO sarah;

--
-- Name: peak; Type: TABLE; Schema: public; Owner: sarah
--

CREATE TABLE public.peak (
    id bigint NOT NULL,
    datefrom timestamp without time zone,
    dateto timestamp without time zone,
    name character varying(255),
    total integer NOT NULL
);


ALTER TABLE public.peak OWNER TO sarah;

--
-- Name: person; Type: TABLE; Schema: public; Owner: sarah
--

CREATE TABLE public.person (
    id bigint NOT NULL,
    age integer NOT NULL,
    name character varying(255),
    surname character varying(255)
);


ALTER TABLE public.person OWNER TO sarah;

--
-- Name: throughput; Type: TABLE; Schema: public; Owner: sarah
--

CREATE TABLE public.throughput (
    id bigint NOT NULL,
    nopassengers integer NOT NULL,
    previousperiod real NOT NULL
);


ALTER TABLE public.throughput OWNER TO sarah;

--
-- Data for Name: passengerstiming; Type: TABLE DATA; Schema: public; Owner: sarah
--

COPY public.passengerstiming (id, xlabel, yvalue) FROM stdin;
1	<15.0s	36
2	<17.5s	62
3	<20.0s	75
4	<22.5s	82
5	<25.0s	87
6	<27.5s	91
7	<30.0s	92
8	<40.0s	96
\.


--
-- Data for Name: peak; Type: TABLE DATA; Schema: public; Owner: sarah
--

COPY public.peak (id, datefrom, dateto, name, total) FROM stdin;
9	2018-12-13 10:13:00	2018-12-14 10:07:00	Peak 24 hr	606
10	2018-12-13 10:07:00	2018-12-13 11:07:00	Peak 1	214
11	2018-12-13 10:16:00	2018-12-13 10:46:00	Peak 30 mins	156
12	2018-12-13 10:13:00	2018-12-13 10:28:00	Peak 15 mins	91
\.


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: sarah
--

COPY public.person (id, age, name, surname) FROM stdin;
14	30	John	Connor
\.


--
-- Data for Name: throughput; Type: TABLE DATA; Schema: public; Owner: sarah
--

COPY public.throughput (id, nopassengers, previousperiod) FROM stdin;
13	606	234.8
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: sarah
--

SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);


--
-- Name: passengerstiming passengerstiming_pkey; Type: CONSTRAINT; Schema: public; Owner: sarah
--

ALTER TABLE ONLY public.passengerstiming
    ADD CONSTRAINT passengerstiming_pkey PRIMARY KEY (id);


--
-- Name: peak peak_pkey; Type: CONSTRAINT; Schema: public; Owner: sarah
--

ALTER TABLE ONLY public.peak
    ADD CONSTRAINT peak_pkey PRIMARY KEY (id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: sarah
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: throughput throughput_pkey; Type: CONSTRAINT; Schema: public; Owner: sarah
--

ALTER TABLE ONLY public.throughput
    ADD CONSTRAINT throughput_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

