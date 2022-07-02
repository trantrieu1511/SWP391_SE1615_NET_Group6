/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class Salary extends Profile {

    public String profile_id;
    public double basic_salary, DA, HRA, conveyance, allowance, medical_allowance,
            TDS, ESI, PF, leave, loan, professional_tax,
            net_salary; //net salary will be actual employee's salary earned
    //(nếu ai làm phần gì mà cần đến salary của employee thì lấy net_salary nhé - Triệu)
    public String create_date;

    public Salary() {
    }

    //list all Staff and Manager constructor
    public Salary(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, int department_id, String reportto, double basic_salary, double DA, double HRA, double conveyance, double allowance, double medical_allowance, double TDS, double ESI, double PF, double leave, double loan, double professional_tax, double net_salary, String create_date) {
        super(profile_id, first_name, last_name, email, phone_number, hire_date, job_id, department_id, reportto);
        this.basic_salary = basic_salary;
        this.DA = DA;
        this.HRA = HRA;
        this.conveyance = conveyance;
        this.allowance = allowance;
        this.medical_allowance = medical_allowance;
        this.TDS = TDS;
        this.ESI = ESI;
        this.PF = PF;
        this.leave = leave;
        this.loan = loan;
        this.professional_tax = professional_tax;
        this.net_salary = net_salary;
        this.create_date = create_date;
    }

    //constructor for choose staff option in add Salary
    public Salary(String profile_id, String first_name, String last_name, double basic_salary) {
        super(profile_id, first_name, last_name);
        this.basic_salary = basic_salary;
    }

    //get net_salary constructor
    public Salary(String profile_id, double basic_salary, double DA, double HRA, double conveyance, double allowance, double medical_allowance, double TDS, double ESI, double PF, double leave, double loan, double professional_tax, double net_salary, String create_date) {
        this.profile_id = profile_id;
        this.basic_salary = basic_salary;
        this.DA = DA;
        this.HRA = HRA;
        this.conveyance = conveyance;
        this.allowance = allowance;
        this.medical_allowance = medical_allowance;
        this.TDS = TDS;
        this.ESI = ESI;
        this.PF = PF;
        this.leave = leave;
        this.loan = loan;
        this.professional_tax = professional_tax;
        this.net_salary = net_salary;
        this.create_date = create_date;
    }

    //add constructor
    public Salary(String profile_id, double basic_salary, double DA, double HRA, double conveyance, double allowance, double medical_allowance, double TDS, double ESI, double PF, double leave, double loan, double professional_tax, String create_date) {
        this.profile_id = profile_id;
        this.basic_salary = basic_salary;
        this.DA = DA;
        this.HRA = HRA;
        this.conveyance = conveyance;
        this.allowance = allowance;
        this.medical_allowance = medical_allowance;
        this.TDS = TDS;
        this.ESI = ESI;
        this.PF = PF;
        this.leave = leave;
        this.loan = loan;
        this.professional_tax = professional_tax;
        this.create_date = create_date;
    }

    //edit constructor
    public Salary(String profile_id, double basic_salary, double DA, double HRA, double conveyance, double allowance, double medical_allowance, double TDS, double ESI, double PF, double leave, double loan, double professional_tax) {
        this.profile_id = profile_id;
        this.basic_salary = basic_salary;
        this.DA = DA;
        this.HRA = HRA;
        this.conveyance = conveyance;
        this.allowance = allowance;
        this.medical_allowance = medical_allowance;
        this.TDS = TDS;
        this.ESI = ESI;
        this.PF = PF;
        this.leave = leave;
        this.loan = loan;
        this.professional_tax = professional_tax;
    }

    public String getProfile_id2() {
        return profile_id;
    }

    public void setProfile_id2(String profile_id) {
        this.profile_id = profile_id;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getDA() {
        return DA;
    }

    public void setDA(double DA) {
        this.DA = DA;
    }

    public double getHRA() {
        return HRA;
    }

    public void setHRA(double HRA) {
        this.HRA = HRA;
    }

    public double getConveyance() {
        return conveyance;
    }

    public void setConveyance(double conveyance) {
        this.conveyance = conveyance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getMedical_allowance() {
        return medical_allowance;
    }

    public void setMedical_allowance(double medical_allowance) {
        this.medical_allowance = medical_allowance;
    }

    public double getTDS() {
        return TDS;
    }

    public void setTDS(double TDS) {
        this.TDS = TDS;
    }

    public double getESI() {
        return ESI;
    }

    public void setESI(double ESI) {
        this.ESI = ESI;
    }

    public double getPF() {
        return PF;
    }

    public void setPF(double PF) {
        this.PF = PF;
    }

    public double getLeave() {
        return leave;
    }

    public void setLeave(double leave) {
        this.leave = leave;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getProfessional_tax() {
        return professional_tax;
    }

    public void setProfessional_tax(double professional_tax) {
        this.professional_tax = professional_tax;
    }

    public double getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(double net_salary) {
        this.net_salary = net_salary;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return super.toString() + " Salary{" + "profile_id=" + profile_id + ", basic_salary=" + basic_salary + ", DA=" + DA + ", HRA=" + HRA + ", conveyance=" + conveyance + ", allowance=" + allowance + ", medical_allowance=" + medical_allowance + ", TDS=" + TDS + ", ESI=" + ESI + ", PF=" + PF + ", leave=" + leave + ", loan=" + loan + ", professional_tax=" + professional_tax + ", net_salary=" + net_salary + ", create_date=" + create_date + '}';
    }

}
