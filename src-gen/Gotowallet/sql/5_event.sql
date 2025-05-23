--
-- Data for Name: event_comp; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.event_comp VALUES 
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Concert A', '2025-06-01', 'Jakarta Convention Center', 'A major music event featuring local bands.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Tech Conference 2025', '2025-07-15', 'Bali Nusa Dua', 'Annual conference on AI, IoT, and Big Data.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Startup Pitch Day', '2025-08-20', 'Bandung Innovation Hub', 'Startups pitch to VCs for funding.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Film Festival', '2025-09-05', 'Jakarta Art House', 'Screening of indie films with panel discussions.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Book Fair', '2025-10-10', 'Surabaya Expo Center', 'Book signing, release and exhibition.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3169ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Food Carnival', '2025-11-03', 'Yogyakarta Square', 'A culinary journey featuring top chefs and street food.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3179ff33-6dd2-4c0a-b113-a90ee32a01ca', 'E-Sports Championship', '2025-12-08', 'Jakarta Gaming Arena', 'National competition for popular e-sports games.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3189ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Dance Workshop Series', '2025-06-20', 'Bali Dance Academy', 'Workshops on modern and traditional dance forms.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3199ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Art Expo 2025', '2025-07-28', 'Bandung Art Gallery', 'Contemporary art exhibition by emerging artists.', 'TicketingSystem.event.core.EventImpl', 'event_impl'),
('3209ff33-6dd2-4c0a-b113-a90ee32a01ca', 'National Debate Championship', '2025-08-10', 'Universitas Indonesia', 'Debate competition for top university teams.', 'TicketingSystem.event.core.EventImpl', 'event_impl');

--
-- Name: event_comp event_comp_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_comp
    ADD CONSTRAINT event_comp_pkey PRIMARY KEY (id);

--
-- Data for Name: event_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.event_impl VALUES 
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3169ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3179ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3189ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3199ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3209ff33-6dd2-4c0a-b113-a90ee32a01ca');

--
-- Name: event_impl event_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_impl
    ADD CONSTRAINT event_impl_pkey PRIMARY KEY (id);

--
-- Name: event_impl fk_event_impl_event_comp; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.event_impl
    ADD CONSTRAINT fk_event_impl_event_comp FOREIGN KEY (id) REFERENCES public.event_comp(id);

--
-- PostgreSQL database dump complete
--
