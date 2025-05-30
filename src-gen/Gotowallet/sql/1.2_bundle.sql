-- Insert data into bundling_comp
INSERT INTO public.bundling_comp (
    id, bundlingname, price, availability, objectname, ticketimpl_idticket
) VALUES
-- Bundling for Ticket 1
('4019ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Bundling Hemat A', 150000, 50, 'bundling_impl', '1019ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Bundling for Ticket 2
('4029ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Bundling Spesial B', 200000, 30, 'bundling_impl', '1029ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Bundling for Ticket 3
('4039ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Bundling VIP C', 300000, 20, 'bundling_impl', '1039ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Bundling for Ticket 4
('4049ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Bundling Couple D', 250000, 40, 'bundling_impl', '1049ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Primary Key
ALTER TABLE ONLY public.bundling_comp
    ADD CONSTRAINT bundling_comp_pkey PRIMARY KEY (id);

-- Foreign Key to ticket_impl
ALTER TABLE ONLY public.bundling_comp
    ADD CONSTRAINT fk_bundling_ticket
    FOREIGN KEY (ticketimpl_idticket)
    REFERENCES public.ticket_impl (idticket);

-- Insert subclass rows into bundling_impl
INSERT INTO public.bundling_impl VALUES 
('4019ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4029ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4039ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4049ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Primary Key for subclass
ALTER TABLE ONLY public.bundling_impl
    ADD CONSTRAINT bundling_impl_pkey PRIMARY KEY (id);

-- FK from subclass to parent table
ALTER TABLE ONLY public.bundling_impl
    ADD CONSTRAINT fk_bundling_impl_comp
    FOREIGN KEY (id)
    REFERENCES public.bundling_comp (id);
