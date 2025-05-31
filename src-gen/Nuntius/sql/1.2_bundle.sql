-- Ensure required tickets exist before this
-- Insert Bundling Components

INSERT INTO public.bundling_comp (
    id, bundlingname, price, availability, ticketimpl_id, objectname
) VALUES
('4119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Konser A VIP Bundle', 450000, 50, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.bundling.core.BundlingImpl'),
('4129ff34-6dd2-4c0a-b113-a90ee32a01ca', 'Konser B Regular Bundle', 200000, 100, '3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.bundling.core.BundlingImpl'),
('4139ff35-6dd2-4c0a-b113-a90ee32a01ca', 'Seminar C Early Bird Bundle', 120000, 30, '3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.bundling.core.BundlingImpl'),
('4149ff36-6dd2-4c0a-b113-a90ee32a01ca', 'Seminar D General Bundle', 180000, 75, '3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.bundling.core.BundlingImpl'),
('4159ff37-6dd2-4c0a-b113-a90ee32a01ca', 'Festival E Backstage Bundle', 700000, 10, '3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'TicketingSystem.bundling.core.BundlingImpl');

-- Insert corresponding Bundling Implementations

INSERT INTO public.bundling_impl VALUES ('4119ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.bundling_impl VALUES ('4129ff34-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.bundling_impl VALUES ('4139ff35-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.bundling_impl VALUES ('4149ff36-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.bundling_impl VALUES ('4159ff37-6dd2-4c0a-b113-a90ee32a01ca');

-- Constraints (only needed if not already defined in schema migration)
-- ALTER TABLE ONLY public.bundling_comp
--     ADD CONSTRAINT bundling_comp_pkey PRIMARY KEY (id);

-- ALTER TABLE ONLY public.bundling_impl
--     ADD CONSTRAINT bundling_impl_pkey PRIMARY KEY (id);

-- ALTER TABLE ONLY public.bundling_impl
--     ADD CONSTRAINT fk_bundling_comp FOREIGN KEY (id) REFERENCES public.bundling_comp(id);

-- ALTER TABLE ONLY public.bundling_comp
--     ADD CONSTRAINT fk_ticket_impl FOREIGN KEY (ticketimpl_id) REFERENCES public.ticket_impl(id);
