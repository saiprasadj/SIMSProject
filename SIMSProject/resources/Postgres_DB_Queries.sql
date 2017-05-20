 --- If you are going to delete only data please follow this section. Deleting data from Postgre ---
 

 --- If you are going to drop existing tables please follow this section. Droping table from Postgre ---


--DROP Sequence

DROP SEQUENCE "Product_Master_sequence";
DROP SEQUENCE employee_master_sequence;
DROP SEQUENCE warehouse_master_sequence;
DROP SEQUENCE product_master_sequence;
DROP SEQUENCE section_master_sequence;
---------------------------------------------------------------
--DROP SCHEMA
DROP SCHEMA SchemaName;
-- Create Schema: factcatalog

CREATE SCHEMA SchemaName AUTHORIZATION databaseName;

-- Create sequences

-- Sequence: section_master_sequence

CREATE SEQUENCE section_master_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE section_master_sequence
  OWNER TO postgres;


-- Sequence: warehouse_master_sequence

CREATE SEQUENCE warehouse_master_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 11
  CACHE 1;
ALTER TABLE warehouse_master_sequence
  OWNER TO postgres;  

CREATE SEQUENCE employee_master_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE employee_master_sequence
  OWNER TO postgres;

-- Sequence: product_master_sequence

CREATE SEQUENCE product_master_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE product_master_sequence
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

  
  -- DROP TABLE "WareHouse_Master";

CREATE TABLE "WareHouse_Master"
(
  "ID" bigint NOT NULL,
  "WAREHOUSE_NAME" character varying(350),
  "WAREHOUSE_CODE" character varying(300),
  "ALIAS_NAME" character varying(350),
  CONSTRAINT "WareHouse_Master_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "WareHouse_Master"
  OWNER TO postgres;
