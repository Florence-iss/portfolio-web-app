INSERT INTO skill (name, slug, category, display_order) VALUES
    ('Java',        'java',        'Backend',  1),
    ('Spring Boot', 'spring-boot', 'Backend',  2),
    ('.NET',        'dotnet',      'Backend',  3),
    ('Python',      'python',      'Backend',  4),
    ('PostgreSQL',  'postgresql',  'Database', 5),
    ('Kotlin',      'kotlin',      'Mobile',   6),
    ('JavaScript',  'javascript',  'Frontend', 7),
    ('Thymeleaf',   'thymeleaf',   'Frontend', 8),
    ('AWS Bedrock', 'aws-bedrock', 'Cloud',    9),
    ('AWS S3',      'aws-s3',      'Cloud',   10),
    ('Streamlit',   'streamlit',   'Frontend',11),
    ('RAG',         'rag',         'AI',      12);

INSERT INTO project (title, slug, summary, status, featured, display_order) VALUES
    ('ReTech', 'retech',
     'E-waste collection platform (NUS-ISS team project, 7 members). I built the full collection officer module: dashboard with route map, bins to collect and collected, distance and time left, and damaged/lost bin reporting.',
     'PUBLISHED', TRUE, 1),
    ('Docker Docs RAG Bot', 'docker-docs-rag-bot',
     'Chatbot that answers questions from Docker''s official docs using a Bedrock Knowledge Base, with a Streamlit web UI.',
     'PUBLISHED', TRUE, 2),
    ('Portfolio Website', 'portfolio-website',
     'This site: Spring Boot, Thymeleaf and PostgreSQL, with Flyway migrations.',
     'PUBLISHED', FALSE, 3);

INSERT INTO project_skill (project_id, skill_id)
SELECT p.id, s.id FROM project p, skill s
WHERE p.slug = 'retech' AND s.slug IN ('dotnet', 'kotlin', 'javascript');

INSERT INTO project_skill (project_id, skill_id)
SELECT p.id, s.id FROM project p, skill s
WHERE p.slug = 'docker-docs-rag-bot' AND s.slug IN ('python', 'aws-bedrock', 'aws-s3', 'streamlit', 'rag');

INSERT INTO project_skill (project_id, skill_id)
SELECT p.id, s.id FROM project p, skill s
WHERE p.slug = 'portfolio-website' AND s.slug IN ('java', 'spring-boot', 'thymeleaf', 'postgresql');