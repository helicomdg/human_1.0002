package proxy;//package proxy;
//
//
//    interface dataExcute {
//        public void executeDatabase(String query) throws Exception;
//    }
//
//    class DatabaseExecuterImpl implements dataExcute {
//
//        @Override
//        public void executeDatabase(String query) throws Exception {
//            System.out.println("Going to execute Query: " + query);
//        }
//
//    }
//
//    class DatabaseExecuterProxy implements dataExcute {
//        boolean ifAdmin;
//        DatabaseExecuterImpl dbExecuter;
//
//        public DatabaseExecuterProxy(String name, String passwd) {
//            if(name == "Admin" && passwd == "Admin@123") {
//                ifAdmin = true;
//            }
//            dbExecuter = new DatabaseExecuterImpl();
//        }
//
//        @Override
//        public void executeDatabase(String query) throws Exception {
//            if(ifAdmin) {
//                dbExecuter.executeDatabase(query);
//            } else {
//                if(query.equals("DELETE")) {
//                    throw new Exception("DELETE not allowed for non-admin user");
//                } else {
//                    dbExecuter.executeDatabase(query);
//                }
//            }
//        }
//    }
//
//   public class proxy {
//
//        public void main(String[] args) throws Exception {
//            dataExcute nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin");
//            nonAdminExecuter.executeDatabase("DELETE");
//
//            dataExcute nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
//            nonAdminExecuterDELETE.executeDatabase("DELETE");
//
//
//            dataExcute adminExecuter = new DatabaseExecuterProxy("Admin", "Admin");
//            adminExecuter.executeDatabase("DELETE");
//
//        }
//
//    }

//Behavioral: Chain of Responsibility
//Creational: Singleton
//Structural: Facade