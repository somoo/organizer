package login;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class LoginUI extends HorizontalLayout {
	

	private FormLayout loginForm;
	private TextField tfUsername;
	private TextField tfPassword;
	private Button btnLogin;
	
	

	public LoginUI() {
		
		initComponent();
		initLayout();
		initComponentTree();

	}
	private void initComponent() {

		loginForm = new FormLayout();
		tfUsername = new TextField();
		tfUsername.setCursorPosition(0);
		tfUsername.setPlaceholder("username");
		tfPassword = new TextField();
		tfPassword.setPlaceholder("password");
		btnLogin = new Button("login");
		
	};
	private void initLayout() {
		this.setWidth(100, Unit.PERCENTAGE);
    	this.setSpacing(true);
    	this.setMargin(true);
    	this.setHeight(100, Unit.PERCENTAGE);
    	
    	loginForm.setWidth(20, Unit.PERCENTAGE);
    	
    	tfUsername.setWidth("300px");
    	
    	tfPassword.setWidth("300px");
    	
    	btnLogin.setWidth("300px");
    	
	}
	private void initComponentTree() {
		
		loginForm.addComponents(tfUsername,tfPassword,btnLogin);
		
		this.addComponent(loginForm);
		
    	this.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    	

	}




}
