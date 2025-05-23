--
-- PostgreSQL database dump
--
--
-- Data for Name: eventorganizer_comp; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.eventorganizer_comp VALUES ('2119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'hendra@user.com', 'Hendra I.', 'TicketingSystem.eventorganizer.core.EventOrganzierImpl', 'eventorganizer_impl');
INSERT INTO public.eventorganizer_comp VALUES ('2129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'indah@user.com', 'Indah J.', 'TicketingSystem.eventorganizer.core.EventOrganzierImpl', 'eventorganizer_impl');
INSERT INTO public.eventorganizer_comp VALUES ('2139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'joko@user.com', 'Joko K.', 'TicketingSystem.eventorganizer.core.EventOrganzierImpl', 'eventorganizer_impl');
INSERT INTO public.eventorganizer_comp VALUES ('2149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'kiki@user.com', 'Kiki L.', 'TicketingSystem.eventorganizer.core.EventOrganzierImpl', 'eventorganizer_impl');
INSERT INTO public.eventorganizer_comp VALUES ('2159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'lina@user.com', 'Lina M.', 'TicketingSystem.eventorganizer.core.EventOrganizerImpl', 'eventorganizer_impl');


--
-- Name: eventorganizer_comp eventorganizer_comp_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.eventorganizer_comp
    ADD CONSTRAINT eventorganizer_comp_pkey PRIMARY KEY (id);


--
-- Name: eventorganizer_comp uksgy2awg3v8vv8pt8t8srb7a2s; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.eventorganizer_comp
    ADD CONSTRAINT uksgy2awg3v8vv8pt8t8srb7a2s UNIQUE (email);


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database dump
--
-- Data for Name: eventorganizer_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.eventorganizer_impl VALUES ('2119ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.eventorganizer_impl VALUES ('2129ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.eventorganizer_impl VALUES ('2139ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.eventorganizer_impl VALUES ('2149ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.eventorganizer_impl VALUES ('2159ff33-6dd2-4c0a-b113-a90ee32a01ca');


--
-- Name: eventorganizer_impl eventorganizer_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.eventorganizer_impl
    ADD CONSTRAINT eventorganizer_impl_pkey PRIMARY KEY (id);


--
-- Name: eventorganizer_impl fkcgt3b11pyw11nfm3b5gwhesjl; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.eventorganizer_impl
    ADD CONSTRAINT fkcgt3b11pyw11nfm3b5gwhesjl FOREIGN KEY (id) REFERENCES public.eventorganizer_comp(id);


--
-- PostgreSQL database dump complete
--

