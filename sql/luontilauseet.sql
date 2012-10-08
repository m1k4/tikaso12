-- Käyttäjä-taulun luonti
CREATE TABLE kayttajat (
  id serial NOT NULL, PRIMARY KEY,
  kayttajanimi varchar NOT NULL, UNIQUE,
  salana varchar NOT NULL
);

-- Leffa-taulun luonti
CREATE TABLE leffat (
  id serial NOT NULL, PRIMARY KEY,
  nimi varchar NOT NULL,
  vuosi integer,
  genre varchar REFERENCES genret(genre),
  ohjaaja varchar,
  kesto time(0)
);

-- KatsottuLeffa-taulun luonti
CREATE TABLE katsotutLeffat (
  leffatunnus serial NOT NULL,
  kayttajatunnus serial NOT NULL,
  arvosana integer,
  katsottu date,
  constraint pk PRIMARY KEY (leffatunnus, kayttajatunnus),
  constraint fk_leffa FOREIGN KEY (leffatunnus) REFERENCES leffat(id),
  constraint fk_kayttaja FOREIGN KEY (kayttajatunnus) REFERENCES kayttajat(id),
);

-- Genre-taulun luonti
CREATE TABLE genret (
  genre varchar NOT NULL,
  leffatunnus serial
  constraint pk PRIMARY KEY (genre, leffatunnus),
  constraint fk_leffa FOREIGN (leffatunnus) REFERENCES leffat(id)
);

-- LeffaEhdotus-taulun luonti
CREATE TABLE ehdotukset (
  id serial NOT NULL, PRIMARY KEY,
  kayttajatunnus varchar NOT NULL,
  constraint fk_kayttaja FOREIGN KEY (kayttajatunnus) REFERENCES kayttajat(id),
  ehdotettu date
);


   
