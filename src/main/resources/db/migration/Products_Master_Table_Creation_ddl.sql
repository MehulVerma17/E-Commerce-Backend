-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE IF NOT EXISTS public.product (
                                price int4 NOT NULL,
                                id uuid NOT NULL,
                                brand varchar(255),
                                category varchar(255),
                                description varchar(255),
                                image varchar(3000),
                                name varchar(255),
                                CONSTRAINT product_pkey PRIMARY KEY (id)
);