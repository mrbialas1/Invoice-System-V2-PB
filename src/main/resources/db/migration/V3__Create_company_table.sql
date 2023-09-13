CREATE TABLE public.company
(
    id bigserial NOT NULL,
    address character varying(200) NOT NULL,
    name character varying(100) NOT NULL,
    pension_insurance numeric(10, 2) NOT NULL,
    health_insurance numeric(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.companies
    OWNER to postgres;