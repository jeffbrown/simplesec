import demo.security.*

class BootStrap {

    def init = { servletContext ->
        if (!User.count()) {
            createData()
        }
    }

    private void createData() {
        def userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)
        new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        ['jeff', 'jason'].each { userName ->
            def user = new User(username: userName, password: 'password', enabled: true).save(failOnError: true)
            UserRole.create user, userRole, true
        }
    }
    def destroy = {
    }
}
