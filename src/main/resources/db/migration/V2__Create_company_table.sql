CREATE TABLE public.company
(
    id                bigserial              NOT NULL,
    address           character varying(200) NOT NULL,
    "taxId"           character varying(100) NOT NULL,
    name              character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXIST public.company
    OWNER to postgres;