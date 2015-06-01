
import java.sql.*;
import java.util.*;

class admin {

    main m;
    int inf[][] = new int[2][4];
    int temp1[] = new int[100];
    int z = 0, x = 0, c = 0, v = 0, max, min, cv = 0, k = 0, mn = 1;
    String year = null, req = null, room = null;
    dataabase b = m.senddatabase();

    int check1() {
        int q = 1;

        if (cv < k) {

            q = temp1[cv];
            cv = cv + 1;
        } else {
            q = max + 1;
        }
        return q;
    }

    void deallot() {
        int y1, k = 0;
        year = null;
        req = null;
        String aa = new String();
        String bb = new String();
        int requir = 0;
        System.out.print("enter roll no of student -> ");
        Scanner sc = new Scanner(System.in);
        String y = sc.nextLine();
        String x = "select * from student where(r_no='" + y + "')";
        ResultSet st = b.read(x);
        String A = null;
        try {

            System.out.println("---record of the student ----");
            mn = 1;
            while (st.next()) {
                A = print(st);
            }

            aa = year;
            bb = room;
            k = 0;

        } catch (SQLException asd) {

        }
        String temp = "n";
        if (A != null) {
            System.out.println("DO YOU WANT TO DE-ALLOTE (Y/N)->");
            Scanner sc1 = new Scanner(System.in);
            temp = sc1.nextLine();
        }
        String Q = "delete from student where r_no= '" + y + "' ;";
        if (temp.equals("y")) {
            b.towrite(Q);
            System.out.println("STUDENT OF ROLL NO " + y + " IS DE-ALLOTED");
            k = 1;
        }
        if (k == 1) {
            System.out.print("DO YOU WANT TO ALLOTE NEW STUDENT FROM WAIGHING LIST Y/N->");
            String am = sc.nextLine();
            if (am.equals("y")) {

                newallot(year, bb, req);

            }
        } else if (A == null) {
            System.out.println("---ROLL NUMBER NOT FOUND---");
        }

    }

    void newallot(String y, String r, String require) {
        String rn = null;
        String nm = new String();

        String A = "select * from student where room= " + "'" + 0 + "' and year =" + "'" + y + "' and r_ment=" + require + " limit 1;";

        ResultSet st = b.read(A);
        try {

            mn = 1;
            while (st.next()) {
                rn = print(st);
            }

        } catch (SQLException asd) {
        }

        String G = "update student set room=" + "'" + r + "'" + "where r_no=" + "'" + rn + "'";
        if (rn == null) {
            System.out.println("NO STUDENT IN WAIGHTING LIST ");
        }
        b.towrite(G);

    }

    void studentrecord(String x, String B) {

        String A = "select * from student where  " + B + "=" + "'" + x + "'";
        String temp = null;

        ResultSet st = b.read(A);
        try {
            mn = 1;
            while (st.next()) {
                temp = print(st);
            }
            if (temp == null) {
                System.out.println("EMPTY OR NOT FOUND");
            }

        } catch (SQLException asd) {
        }
    }

    int admincheck() {
        int x = 0;
        System.out.print("user name -> ");
        Scanner sc1 = new Scanner(System.in);
        String user = sc1.nextLine();
        System.out.print("password -> ");
        Scanner sc2 = new Scanner(System.in);
        String pass = sc2.nextLine();
        String A = "select * from admin";
        ResultSet st = b.read(A);
        try {
            while (st.next()) {
                String a = st.getString("name");
                String b = st.getString("pass");
                if (a.equals(user) && b.equals(pass)) {
                    x = 1;
                }
            }

        } catch (SQLException asd) {
        }
        if (x == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    void allot() {
        int temp[][] = new int[4][50];
        for (int fori = 1; fori < 4; fori++) {
            cv = 0;

            String sr = "select * from student where r_ment=" + fori + ";";
          //  System.out.println(s1);

            String hr = "select max(room) from hostel_room where capacity=" + fori + ";";

            try {
                String s1 = "select * from hostel_room where capacity=" + fori + ";";

                ResultSet tempset = b.read(hr);
                tempset.next();
                max = tempset.getInt("max(room)");
                tempset = b.read(s1);
                for (int tempq = 0; tempq < 4; tempq++) {

                    inf[0][tempq] = 99999;

                }
                int y = 0, j = 0, i = 1;
                // tempset = b.read(s1);
                k = 0;
                while (tempset.next()) {
                    temp1[y] = tempset.getInt("room");

                    y = y + 1;
                    k = k + 1;

                }
                y = 0;
                tempset = b.read(sr);

                while (tempset.next()) {
                    j++;
                    int year = tempset.getInt("year");
                    int r_no = tempset.getInt("r_no");

                    temp[0][y] = year;
                    temp[1][y] = r_no;

                    y++;
                }

                y = 0;
                int record = 0;
                while ((i <= j)) {
                    if (temp[0][y] != 0) {

                        allotment(temp[0][y], temp[1][y], fori);
                        record = record + 1;

                    }

                    y++;
                    i++;
                }
                if (temp[0][0] != 0) {
                    System.out.println("---- " + fori + " seeter ROOM ALLOTED ");
                } else {
                    System.out.println("-----NO STUDENT FOR " + fori + " SEATER-------");
                }
                y = 0;
                temp[0][0] = 0;

            } catch (SQLException asd) {
                asd.printStackTrace();
            }
        }
    }

    void allotment(int y, int roll, int foro) {

        int m = 0;
        if (inf[0][y - 1] == 99999) {
            inf[1][y - 1] = 0;
            inf[0][y - 1] = check1();

            String B = "update student set room= '" + inf[0][y - 1] + "' where r_no= " + "'" + roll + "' ";

            inf[1][y - 1] = inf[1][y - 1] + 1;
            b.towrite(B);
        } else if (inf[0][y - 1] <= max) {
            if (inf[1][y - 1] < foro) {

                String B = "update student set room= '" + inf[0][y - 1] + "' where r_no= " + "'" + roll + "' ;";

                b.towrite(B);
                inf[1][y - 1] = inf[1][y - 1] + 1;
            } else {
                int a = check1();

                inf[0][y - 1] = a;
                if (a <= max) {
                    inf[1][y - 1] = 1;
                    String B = "update student set room= '" + inf[0][y - 1] + "' where r_no= " + "'" + roll + "' ";
                    b.towrite(B);
                    m = inf[0][y - 1];
                }
            }
        }

    }

    void roomrecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER ROOM NO       -> ");
        int room = sc.nextInt();
        System.out.print("ENTER ROOM CAPACITY -> ");
        int capecity = sc.nextInt();
        String p = "insert into hostel_room values(" + room + "," + capecity + ")";

        b.towrite(p);

    }

    String print(ResultSet st) {
        String m = null;
        try {

            if (mn == 1) {
                System.out.println("|------+----------+------+--------+------+--------+");
                System.out.println("| r_no |  name    | year | branch | room | seater |");
                System.out.println("|------+----------+------+--------+------+--------+");
                mn = 0;
            }
            System.out.print("|");
            System.out.print(" ");
            String A1 = st.getString("r_no");
            m = A1;
            System.out.print(A1);
            for (int i = 1; i < 6 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");
            A1 = st.getString("name");
            System.out.print(A1);
            for (int i = 1; i <= 9 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");
            A1 = st.getString("year");
            year = A1;
            System.out.print(A1);
            for (int i = 1; i <= 5 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");
            A1 = st.getString("branch");
            System.out.print(A1);
            for (int i = 1; i <= 7 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");

            A1 = st.getString("room");
            room = A1;
            System.out.print(A1);
            for (int i = 1; i <= 5 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print(" ");
            A1 = st.getString("r_ment");
            req = A1;
            System.out.print(A1);
            for (int i = 1; i <= 7 - A1.length(); i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            System.out.println();
            System.out.println("|------+----------+------+--------+------+--------+");

        } catch (SQLException asb) {
        }
        return m;
    }
}
