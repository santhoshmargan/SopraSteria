import { AuthService } from "./auth.service";

export function appInitializer(authService: AuthService) {
    return (): any =>
        new Promise((resolve) => {
            const obj = {
                'username': sessionStorage.getItem('username'), 
                'password': sessionStorage.getItem('password') 
            }
            authService.login(obj).subscribe().add(resolve);
        });
}