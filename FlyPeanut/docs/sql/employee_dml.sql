-- ���� �α��� ��ȸ
select e_kname from employee where e_id=123456 and e_pw='password';
-- select e_kname from employee where e_id=? and e_pw=?

-- ��ȣã��(�ӽù߱޾�ȣ���� ��ȯ)
update members set e_pw=?  where e_id=? and e_kname=? and e_birth=? and e_email=?

--����������
select * from employee where e_id='123456';
--select * from employee where e_id=?

--������ ����
update employee set e_mobile='010-1111-2222', e_email='asdf@gamail.com', e_address='�λ�� ������'  
where e_id='12345';

--�������� ����
delete from employee where e_id=?
delete from employee where e_id=123456;