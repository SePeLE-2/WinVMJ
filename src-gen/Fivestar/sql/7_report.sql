-- Isi report_comp
INSERT INTO public.report_comp (
  idreport, eventdate, eventname, idevent, objectname, reportdate, ticketsold, eventimpl_idevent, modulesequence
) VALUES
('a119ff33-6dd2-4c0a-b113-a90ee32a01ca', '2025-06-01', 'Concert A', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.report.core.ReportImpl', '2025-06-02', 98, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('a129ff34-6dd2-4c0a-b113-a90ee32a01ca', '2025-07-15', 'Tech Conference 2025', '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.report.core.ReportImpl', '2025-07-16', 276, '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('a139ff35-6dd2-4c0a-b113-a90ee32a01ca', '2025-08-20', 'Startup Pitch Day', '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.report.core.ReportImpl', '2025-08-21', 47, '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('a149ff36-6dd2-4c0a-b113-a90ee32a01ca', '2025-09-05', 'Film Festival', '3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.report.core.ReportImpl', '2025-09-06', 143, '3149ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('a159ff37-6dd2-4c0a-b113-a90ee32a01ca', '2025-10-10', 'Book Fair', '3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.report.core.ReportImpl', '2025-10-11', 19, '3159ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL);

-- Isi report_impl (pastikan sama persis dengan idreport di atas)
INSERT INTO public.report_impl (idreport) VALUES
('a119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('a129ff34-6dd2-4c0a-b113-a90ee32a01ca'),
('a139ff35-6dd2-4c0a-b113-a90ee32a01ca'),
('a149ff36-6dd2-4c0a-b113-a90ee32a01ca'),
('a159ff37-6dd2-4c0a-b113-a90ee32a01ca');
