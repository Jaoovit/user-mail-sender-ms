CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE emails (
       id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
       user_id UUID NOT NULL,
       send_to VARCHAR(100) NOT NULL,
       send_by VARCHAR(100) NOT NULL,
       subject VARCHAR(250) NOT NULL,
       body VARCHAR(350) NOT NULL
);