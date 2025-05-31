-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
select * from public.payment_creditcard;

--
-- PostgreSQL database dump
--

-- Data for Name: payment_creditcard; Type: TABLE DATA; Schema: public; Owner: deployer
--

-- Clear existing data (optional)
TRUNCATE TABLE public.payment_creditcard RESTART IDENTITY CASCADE;

-- Insert sample credit card payments
INSERT INTO public.payment_creditcard (
    id, 
    record_id, 
    recordname, 
    base_component_id
) VALUES 
-- Payment 1
('5019ff33-6dd2-4c0a-b113-a90ee32a01ca', '5019ff33-6dd2-4c0a-b113-a90ee32a01ca', 'VIP Ticket Payment', '5019ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Payment 2
('5029ff33-6dd2-4c0a-b113-a90ee32a01ca', '5029ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Regular Ticket Payment', '5029ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Payment 3
('5039ff33-6dd2-4c0a-b113-a90ee32a01ca', '5039ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Early Bird Payment', '5039ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Payment 4
('5049ff33-6dd2-4c0a-b113-a90ee32a01ca', '5049ff33-6dd2-4c0a-b113-a90ee32a01ca', 'General Admission Payment', '5049ff33-6dd2-4c0a-b113-a90ee32a01ca');