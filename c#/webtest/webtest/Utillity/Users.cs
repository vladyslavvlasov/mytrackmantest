using System;
namespace webtest
{
    public class Users
    {
        public String name;
        public String username;
        public String password;

        public Users(String name, String username, String password)
        {
            this.name = name;
            this.username = username;
            this.password = password;
        }

        public static Users defaultUser = new Users("Johnny Horseshoe","johnhoe","password123");

    }


}
