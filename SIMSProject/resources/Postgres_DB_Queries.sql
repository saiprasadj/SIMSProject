 --- If you are going to delete only data please follow this section. Deleting data from Postgre ---
 

 --- If you are going to drop existing tables please follow this section. Droping table from Postgre ---
drop table factcatalog.CUSTOM_FACT;

--DROP Sequence

DROP SEQUENCE "Product_Master_sequence";

---------------------------------------------------------------
--DROP SCHEMA
DROP SCHEMA SchemaName;
-- Create Schema: factcatalog

CREATE SCHEMA SchemaName AUTHORIZATION databaseName;

-- Create sequences
CREATE SEQUENCE public."Product_Master_sequence"
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 9223372036854775807
   CACHE 1;
ALTER SEQUENCE public."Product_Master_sequence"
  OWNER TO postgres;
--------------------------------------------------------------------------
-- Create tables


CREATE TABLE "Product_Master"
(
  "ID" bigint NOT NULL,
  "PRODUCT_NAME" character varying(300),
  "ALIAS_NAME" character varying(300),
  "PRODUCT_CODE" character varying(300),
  "BUYING_PRICE" double precision,
  "SELLING_PRICE" double precision,
  "UOM" character varying(300),
  "RECORDER_LEVEL" bigint,
  CONSTRAINT "Product_Master_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Product_Master"
  OWNER TO postgres;

