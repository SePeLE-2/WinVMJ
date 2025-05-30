--
-- PostgreSQL database dump
--
-- Data for Name: ticket_comp; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.ticket_comp (
    id, eventname, ticketname, price, availability, objectname
) VALUES 
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Konser A', 'VIP Pass', 500000, 100, 'TicketingSystem.ticket.core.TicketImpl'),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Konser B', 'Regular Pass', 250000, 300, 'TicketingSystem.ticket.core.TicketImpl'),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Seminar C', 'Early Bird', 150000, 50, 'TicketingSystem.ticket.core.TicketImpl'),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Seminar D', 'General Admission', 200000, 150, 'TicketingSystem.ticket.core.TicketImpl'),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Festival E', 'Backstage Pass', 750000, 20, 'TicketingSystem.ticket.core.TicketImpl');


--
-- Name: ticket_comp ticket_comp_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.ticket_comp
    ADD CONSTRAINT ticket_comp_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump
-- Data for Name: ticket_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.ticket_impl VALUES ('3119ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.ticket_impl VALUES ('3129ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.ticket_impl VALUES ('3139ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.ticket_impl VALUES ('3149ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.ticket_impl VALUES ('3159ff33-6dd2-4c0a-b113-a90ee32a01ca');


--
-- Name: ticket_impl ticket_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.ticket_impl
    ADD CONSTRAINT ticket_impl_pkey PRIMARY KEY (id);


--
-- Name: ticket_impl fk_ticket_comp; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.ticket_impl
    ADD CONSTRAINT fk_ticket_comp FOREIGN KEY (id) REFERENCES public.ticket_comp(id);

--
-- PostgreSQL database dump complete
--
