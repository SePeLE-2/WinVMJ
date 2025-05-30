--
-- PostgreSQL database dump
--

-- Sales Report Tables
CREATE TABLE IF NOT EXISTS public.report_salesreport_comp (
    id UUID PRIMARY KEY,
    idreport INTEGER,
    idevent UUID REFERENCES public.event_comp(id),
    eventname VARCHAR(255),
    eventdate DATE,
    reportdate DATE,
    ticketsold INTEGER,
    totalrevenue INTEGER,
    ticketprice INTEGER,
    objectname VARCHAR(255),
    eventimpl_id UUID REFERENCES public.event_impl(id)
);

CREATE TABLE IF NOT EXISTS public.report_salesreport_impl (
    id UUID PRIMARY KEY REFERENCES public.report_salesreport_comp(id)
);

-- Attendance Report Tables
CREATE TABLE IF NOT EXISTS public.report_attendancestats_comp (
    id UUID PRIMARY KEY,
    idreport INTEGER,
    idevent UUID REFERENCES public.event_comp(id),
    eventname VARCHAR(255),
    eventdate DATE,
    reportdate DATE,
    showingattendance INTEGER,
    attendancepercentage INTEGER,
    ticketsold INTEGER,
    objectname VARCHAR(255),
    eventimpl_id UUID REFERENCES public.event_impl(id)
);

CREATE TABLE IF NOT EXISTS public.report_attendancestats_impl (
    id UUID PRIMARY KEY REFERENCES public.report_attendancestats_comp(id)
);

-- Event Rating Report Tables
CREATE TABLE IF NOT EXISTS public.report_eventrating_comp (
    id UUID PRIMARY KEY,
    idreport INTEGER,
    idevent UUID REFERENCES public.event_comp(id),
    eventname VARCHAR(255),
    eventdate DATE,
    reportdate DATE,
    averagerating DECIMAL(3,2),
    totalratings INTEGER,
    objectname VARCHAR(255),
    eventimpl_id UUID REFERENCES public.event_impl(id)
);

CREATE TABLE IF NOT EXISTS public.report_eventrating_impl (
    id UUID PRIMARY KEY REFERENCES public.report_eventrating_comp(id)
);

-- Sample Data for Sales Reports
INSERT INTO public.report_salesreport_comp VALUES
('4119ff33-6dd2-4c0a-b113-a90ee32a01ca', 1, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Concert A', '2025-06-01', '2025-06-02', 500, 2500000, 5000, 'TicketingSystem.report.salesreport.ReportImpl', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4129ff33-6dd2-4c0a-b113-a90ee32a01ca', 2, '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tech Conference 2025', '2025-07-15', '2025-07-16', 300, 1500000, 5000, 'TicketingSystem.report.salesreport.ReportImpl', '3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4139ff33-6dd2-4c0a-b113-a90ee32a01ca', 3, '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Startup Pitch Day', '2025-08-20', '2025-08-21', 200, 1000000, 5000, 'TicketingSystem.report.salesreport.ReportImpl', '3139ff33-6dd2-4c0a-b113-a90ee32a01ca');

INSERT INTO public.report_salesreport_impl VALUES
('4119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4139ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Sample Data for Attendance Reports
INSERT INTO public.report_attendancestats_comp VALUES
('4219ff33-6dd2-4c0a-b113-a90ee32a01ca', 1, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Concert A', '2025-06-01', '2025-06-02', 450, 90, 500, 'TicketingSystem.report.attendancestats.ReportImpl', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4229ff33-6dd2-4c0a-b113-a90ee32a01ca', 2, '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tech Conference 2025', '2025-07-15', '2025-07-16', 280, 93, 300, 'TicketingSystem.report.attendancestats.ReportImpl', '3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4239ff33-6dd2-4c0a-b113-a90ee32a01ca', 3, '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Startup Pitch Day', '2025-08-20', '2025-08-21', 190, 95, 200, 'TicketingSystem.report.attendancestats.ReportImpl', '3139ff33-6dd2-4c0a-b113-a90ee32a01ca');

INSERT INTO public.report_attendancestats_impl VALUES
('4219ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4229ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4239ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Sample Data for Event Rating Reports
INSERT INTO public.report_eventrating_comp VALUES
('4319ff33-6dd2-4c0a-b113-a90ee32a01ca', 1, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Concert A', '2025-06-01', '2025-06-02', 4.5, 450, 'TicketingSystem.report.eventrating.ReportImpl', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4329ff33-6dd2-4c0a-b113-a90ee32a01ca', 2, '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tech Conference 2025', '2025-07-15', '2025-07-16', 4.8, 280, 'TicketingSystem.report.eventrating.ReportImpl', '3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4339ff33-6dd2-4c0a-b113-a90ee32a01ca', 3, '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Startup Pitch Day', '2025-08-20', '2025-08-21', 4.2, 190, 'TicketingSystem.report.eventrating.ReportImpl', '3139ff33-6dd2-4c0a-b113-a90ee32a01ca');

INSERT INTO public.report_eventrating_impl VALUES
('4319ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4329ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4339ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Add Foreign Key Constraints
ALTER TABLE public.report_salesreport_comp
    ADD CONSTRAINT fk_report_salesreport_event
    FOREIGN KEY (idevent)
    REFERENCES public.event_comp(id);

ALTER TABLE public.report_attendancestats_comp
    ADD CONSTRAINT fk_report_attendancestats_event
    FOREIGN KEY (idevent)
    REFERENCES public.event_comp(id);

ALTER TABLE public.report_eventrating_comp
    ADD CONSTRAINT fk_report_eventrating_event
    FOREIGN KEY (idevent)
    REFERENCES public.event_comp(id);

--
-- PostgreSQL database dump complete
-- 