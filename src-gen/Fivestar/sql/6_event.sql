--
-- Data for Name: event_comp; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.event_comp (
  idevent, name, date, location, description, objectname, bundlingimpl_id, ticketimpl_id, modulesequence
) VALUES 
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Concert A', '2025-06-01', 'Jakarta Convention Center', 'A major music event featuring local bands.', 'TicketingSystem.event.core.EventImpl', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '3119ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tech Conference 2025', '2025-07-15', 'Bali Nusa Dua', 'Annual conference on AI, IoT, and Big Data.', 'TicketingSystem.event.core.EventImpl', '4129ff34-6dd2-4c0a-b113-a90ee32a01ca', '3129ff34-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Startup Pitch Day', '2025-08-20', 'Bandung Innovation Hub', 'Startups pitch to VCs for funding.', 'TicketingSystem.event.core.EventImpl', '4139ff35-6dd2-4c0a-b113-a90ee32a01ca', '3139ff35-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Film Festival', '2025-09-05', 'Jakarta Art House', 'Screening of indie films with panel discussions.', 'TicketingSystem.event.core.EventImpl', '4149ff36-6dd2-4c0a-b113-a90ee32a01ca', '3149ff36-6dd2-4c0a-b113-a90ee32a01ca', NULL),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Book Fair', '2025-10-10', 'Surabaya Expo Center', 'Book signing, release and exhibition.', 'TicketingSystem.event.core.EventImpl', '4159ff37-6dd2-4c0a-b113-a90ee32a01ca', '3159ff37-6dd2-4c0a-b113-a90ee32a01ca', NULL);

--
-- Name: event_comp event_comp_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_comp
    ADD CONSTRAINT event_comp_pkey PRIMARY KEY (idevent);

--
-- Data for Name: event_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.event_impl (idevent) VALUES
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca');

--
-- Name: event_impl event_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_impl
    ADD CONSTRAINT event_impl_pkey PRIMARY KEY (idevent);

--
-- Name: event_impl fk_event_impl_event_comp; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_impl
    ADD CONSTRAINT fk_event_impl_event_comp FOREIGN KEY (idevent) REFERENCES public.event_comp(idevent);

--
-- PostgreSQL database dump complete
--
