--������ �°� ��ȸ
select r_num , r_name , r_departure ,r_departuretime,r_arrival,r_arrivaltime, r_seat ,r_anum, to_char(r_date, 'yyyy. mm. dd.') \"r_date\" , r_fname , r_class from reservation where r_name=? and r_num=?";