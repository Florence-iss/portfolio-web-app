-- ===== Profile (one row) =====
INSERT INTO profile (full_name, headline, bio, location, github_url, linkedin_url, open_to_work)
VALUES (
    'Theingi Myint',
    'Backend Developer — Java & Spring Boot',
    'I moved into software from a background in logistics, which taught me to think about how systems and processes fit together. After completing the Graduate Diploma in Systems Analysis at NUS-ISS and an internship at SSMC, I now focus on backend development, building applications with Java and Spring Boot where data flows cleanly between the web, the business logic and the database. I enjoy spending my free time building projects that interest me, like this website. I''m looking for a backend role where I can grow towards my long-term goal of becoming a cloud engineer.',
    'Singapore',
    'https://github.com/Florence-iss',
    'https://www.linkedin.com/in/theingi-myint-b146bb134/',
    TRUE
);

-- ===== Extra skills used at SSMC (ones not already in the skill table) =====
-- Python and .NET already exist from V2, so they are only linked below, not inserted again.
INSERT INTO skill (name, slug, category, display_order) VALUES
    ('Oracle',                 'oracle',                 'Database', 13),
    ('Power BI',               'power-bi',               'Tools',    14),
    ('GoAnywhere MFT',         'goanywhere-mft',         'Tools',    15),
    ('Power Automate Desktop', 'power-automate-desktop', 'Tools',    16);

-- ===== Experience =====
INSERT INTO experience (company, role, employment_type, start_date, end_date, description, display_order)
VALUES (
    'SSMC (Systems on Silicon Manufacturing Company)',
    'Software Engineer Intern',
    'Internship',
    '2026-03-02',
    '2026-07-17',
    'Built a Python tool to compare Oracle and PostgreSQL data during migration. Built Power BI dashboards for IT reporting, including HVR replication monitoring and weekly and monthly ServiceNow reports. Automated file transfer workflows with GoAnywhere MFT and repetitive desktop tasks with Power Automate Desktop.',
    1
);

INSERT INTO experience_skill (experience_id, skill_id)
SELECT e.id, s.id FROM experience e, skill s
WHERE e.company LIKE 'SSMC%'
  AND s.slug IN ('python', 'dotnet', 'oracle', 'postgresql', 'power-bi',
                 'goanywhere-mft', 'power-automate-desktop');

-- ===== Education (newest first) =====
-- Dates are optional: use 'YYYY-MM-DD' or NULL (no quotes)
INSERT INTO education (institution, qualification, start_date, end_date, display_order) VALUES
    ('NUS-ISS',              'Graduate Diploma in Systems Analysis (GDipSA)', NULL, NULL, 1),
    ('Coventry University',  'BSc Global Logistics',                          NULL, NULL, 2),
    ('SIM',                  'Diploma in Information Technology',             NULL, NULL, 3),
    ('PSB Academy',          'Diploma in Business Administration',            NULL, NULL, 4);

-- ===== Certifications =====
-- None yet. Add later with a new migration or from the admin page (Phase 3).