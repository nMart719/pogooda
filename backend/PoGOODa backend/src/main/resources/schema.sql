CREATE TYPE StanPracyStacjiPogodowej_enum AS ENUM (
    'letni',
    'zimowy'
    );

CREATE TYPE StanCzujnika_enum AS ENUM (
    'dobry',
    'bardzo_dobry',
    'normalny',
    'zly'
    );

CREATE TYPE RolaUzytkownika_enum AS ENUM (
    'administrator',
    'pracownik_rolny',
    'producent_rolny',
    'instalator'
    );

CREATE TABLE gwarancja (
    id integer NOT NULL,
    hash_godnosci character varying(255),
    instrukcja_uzytkownika character varying(255)
);

CREATE SEQUENCE gwarancja_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE gwarancja_id_seq OWNED BY gwarancja.id;


CREATE TABLE pomiar_czujnika (
                                        id integer NOT NULL,
                                        czas_odczytu date,
                                        stan_czujnika StanCzujnika_enum,
                                        stacja_pogodowa_id integer
);

CREATE SEQUENCE pomiar_czujnika_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE pomiar_czujnika_id_seq OWNED BY pomiar_czujnika.id;


CREATE TABLE pomiar_czujnika_wew (
                                            maksymalny_zasieg integer,
                                            temperatura_wewnetrzna float,
                                            wilgotnosc_wewnetrzna float,
                                            id integer NOT NULL
);


CREATE TABLE pomiar_czujnika_zew (
                                            cisnienie_atmosferyczne float,
                                            fars float,
                                            jakosc_powietrza float,
                                            opady_deszczu float,
                                            predkosc_wiatru float,
                                            promieniowanie_sloneczne float,
                                            temperatura_odczuwalna float,
                                            temperatura_zewnetrzna float,
                                            uvi float,
                                            wilgotnosc_zewnetrzna float,
                                            id integer NOT NULL
);


CREATE TABLE stacja_pogodowa (
                                        id integer NOT NULL,
                                        stan_pracy StanPracyStacjiPogodowej_enum,
                                        waga_stacji float,
                                        gwarancja_id integer,
                                        wlasciciel_id integer,
                                        wymiary_id integer
);

CREATE SEQUENCE stacja_pogodowa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE stacja_pogodowa_id_seq OWNED BY stacja_pogodowa.id;


CREATE TABLE uzytkownik (
                                   id integer NOT NULL,
                                   created_at date,
                                   login character varying(255),
                                   rola_uzytkownika RolaUzytkownika_enum
);

CREATE SEQUENCE uzytkownik_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE uzytkownik_id_seq OWNED BY uzytkownik.id;


CREATE TABLE wymiary (
                                id integer NOT NULL,
                                dlugosc integer,
                                szerokosc integer,
                                wysokosc integer
);

CREATE SEQUENCE wymiary_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE wymiary_id_seq OWNED BY wymiary.id;



ALTER TABLE ONLY gwarancja ALTER COLUMN id SET DEFAULT nextval('gwarancja_id_seq'::regclass);

ALTER TABLE ONLY pomiar_czujnika ALTER COLUMN id SET DEFAULT nextval('pomiar_czujnika_id_seq'::regclass);

ALTER TABLE ONLY stacja_pogodowa ALTER COLUMN id SET DEFAULT nextval('stacja_pogodowa_id_seq'::regclass);

ALTER TABLE ONLY uzytkownik ALTER COLUMN id SET DEFAULT nextval('uzytkownik_id_seq'::regclass);

ALTER TABLE ONLY wymiary ALTER COLUMN id SET DEFAULT nextval('wymiary_id_seq'::regclass);



ALTER TABLE ONLY gwarancja
    ADD CONSTRAINT gwarancja_pkey PRIMARY KEY (id);


ALTER TABLE ONLY pomiar_czujnika
    ADD CONSTRAINT pomiar_czujnika_pkey PRIMARY KEY (id);


ALTER TABLE ONLY pomiar_czujnika_wew
    ADD CONSTRAINT pomiar_czujnika_wew_pkey PRIMARY KEY (id);


ALTER TABLE ONLY pomiar_czujnika_zew
    ADD CONSTRAINT pomiar_czujnika_zew_pkey PRIMARY KEY (id);


ALTER TABLE ONLY stacja_pogodowa
    ADD CONSTRAINT stacja_pogodowa_pkey PRIMARY KEY (id);


ALTER TABLE ONLY uzytkownik
    ADD CONSTRAINT uzytkownik_pkey PRIMARY KEY (id);


ALTER TABLE ONLY wymiary
    ADD CONSTRAINT wymiary_pkey PRIMARY KEY (id);


ALTER TABLE ONLY stacja_pogodowa
    ADD CONSTRAINT fkenix9j5ybu3j5cmgpk0cr5jsp FOREIGN KEY (wymiary_id) REFERENCES wymiary(id);


ALTER TABLE ONLY pomiar_czujnika
    ADD CONSTRAINT fkgsxn3lg1ct3pf084gk31n5ej9 FOREIGN KEY (stacja_pogodowa_id) REFERENCES stacja_pogodowa(id);


ALTER TABLE ONLY stacja_pogodowa
    ADD CONSTRAINT fklcln1qibi51st2bl5ia24jfh2 FOREIGN KEY (gwarancja_id) REFERENCES gwarancja(id);


ALTER TABLE ONLY pomiar_czujnika_wew
    ADD CONSTRAINT fkn2ltasmj6lcu8nf525wq3c7u FOREIGN KEY (id) REFERENCES pomiar_czujnika(id);


ALTER TABLE ONLY stacja_pogodowa
    ADD CONSTRAINT fkt0fqujscbsh02a6vak7e9p7tb FOREIGN KEY (wlasciciel_id) REFERENCES uzytkownik(id);


ALTER TABLE ONLY pomiar_czujnika_zew
    ADD CONSTRAINT fkt4x08map0u6g7kp0d4f0c8qk0 FOREIGN KEY (id) REFERENCES pomiar_czujnika(id);

