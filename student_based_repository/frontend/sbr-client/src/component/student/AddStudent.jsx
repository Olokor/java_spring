import React, { useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import axios from "axios";

const AddStudent = () => {
    const [student, setStudent] = useState({
        firstName: "",
        lastName: "",
        email: "",
        department: ""
    });
    let navigate = useNavigate();

    const handleInputChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };

    const updateStudent = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/students", student);
            console.log("Student saved successfully:", response.data);
            // Redirect to view students page or clear for
            window.location.href = "/view-students";
        } catch (error) {
            console.error("Error saving student:", error);
        }
    };

    return (
        <div className="col-sm-8 py-2 px-5  shadow-lg">
            <h2 className={"mt-5"}>Add student</h2>
            <form onSubmit={(e) => updateStudent(e)}>
                <div className="row mb-4 align-items-center">
                    <div className="col-sm-3">
                        <label htmlFor="firstName" className="form-label">First Name</label>
                    </div>
                    <div className="col-sm-6">
                        <input
                            className="form-control"
                            name="firstName"
                            type="text"
                            id="firstName"
                            value={student.firstName}
                            onChange={handleInputChange}
                            required
                        />
                    </div>
                </div>

                <div className="row mb-4 align-items-center">
                    <div className="col-sm-3">
                        <label htmlFor="lastName" className="form-label">Last Name</label>
                    </div>
                    <div className="col-sm-6">
                        <input
                            className="form-control"
                            name="lastName"
                            type="text"
                            id="lastName"
                            value={student.lastName}
                            onChange={handleInputChange}
                            required
                        />
                    </div>
                </div>

                <div className="row mb-4 align-items-center">
                    <div className="col-sm-3">
                        <label htmlFor="email" className="form-label">Email</label>
                    </div>
                    <div className="col-sm-6">
                        <input
                            className="form-control"
                            name="email"
                            type="email"
                            id="email"
                            value={student.email}
                            onChange={handleInputChange}
                            required
                        />
                    </div>
                </div>

                <div className="row mb-4 align-items-center">
                    <div className="col-sm-3">
                        <label htmlFor="department" className="form-label">Department</label>
                    </div>
                    <div className="col-sm-6">
                        <input
                            className="form-control"
                            name="department"
                            type="text"
                            id="department"
                            value={student.department}
                            onChange={handleInputChange}
                            required
                        />
                    </div>
                </div>
                <div className="row mb-4 align-items-center">
                    <div className="col-sm-3"></div>
                    <div className="col-sm-6 d-flex gap-3">
                        <button
                            className="btn btn-success px-4 py-2 fw-bold"
                            type="submit"
                        >
                            <i className="bi bi-save me-2"></i>Save
                        </button>
                        <Link
                            className="btn btn-outline-danger px-4 py-2 fw-bold"
                            to="/view-students"
                        >
                            <i className="bi bi-x-circle me-2"></i>Cancel
                        </Link>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default AddStudent;