CREATE TYPE project_status as ENUM (
  'TODO',
  'IN_PROGRESS',
  'DONE'
);

ALTER TABLE projects ALTER COLUMN status TYPE project_status USING status::project_status;
