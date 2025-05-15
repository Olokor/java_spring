import React, {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import axios from "axios";

const EditStudent = () => {
    const { id } = useParams(); // Get the id from the URL parameter
    const navigate = useNavigate();

    const [student, setStudent] = useState({
        firstName: "",
        lastName: "",
        email: "",
        department: ""
    });

    useEffect(() => {
        loadStudent();
    }, []);

    const loadStudent = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/students/${id}`);
            setStudent(result.data);
        } catch (error) {
            console.error("Error loading student:", error);
            alert("Failed to load student data");
        }
    };

    const handleInputChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };

    const updateStudent = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.put(`http://localhost:8080/students/${id}`, student);
            console.log("Student updated successfully:", response.data);
            navigate("/view-students"); // Use navigate instead of window.location
        } catch (error) {
            console.error("Error updating student:", error);
            alert("Failed to update student");
        }
    };

    return (
        <div className="col-sm-8 py-2 px-5 shadow-lg">
            <form onSubmit={(e) => updateStudent(e)}>
                <h2 className="mt-5">Edit Student</h2>
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

export default EditStudent;