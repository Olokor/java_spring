import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { FaEdit, FaArrowLeft } from "react-icons/fa";

const StudentProfile = () => {
    const { id } = useParams();
    const [student, setStudent] = useState({
        firstName: "",
        lastName: "",
        email: "",
        department: ""
    });
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        loadStudent();
    }, []);

    const loadStudent = async () => {
        try {
            setLoading(true);
            const result = await axios.get(`http://localhost:8080/students/${id}`);
            setStudent(result.data);
            setLoading(false);
        } catch (err) {
            setError("Failed to load student data");
            setLoading(false);
            console.error("Error loading student:", err);
        }
    };

    if (loading) {
        return (
            <div className="container py-4 d-flex justify-content-center">
                <div className="spinner-border text-primary" role="status">
                    <span className="visually-hidden">Loading...</span>
                </div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="container py-4">
                <div className="alert alert-danger" role="alert">
                    {error}
                </div>
                <Link to="/view-students" className="btn btn-primary">
                    <FaArrowLeft className="me-2" /> Back to Student List
                </Link>
            </div>
        );
    }

    return (
        <div className="container py-4">
            <div className="row">
                <div className="col-md-8 offset-md-2">
                    <div className="card shadow">
                        <div className="card-header bg-primary text-white">
                            <h3 className="mb-0">Student Profile</h3>
                        </div>
                        <div className="card-body">
                            <div className="row mb-3">
                                <div className="col-md-12 text-center mb-4">
                                    <div className="profile-img-container">
                                        <div className="profile-initial rounded-circle bg-secondary text-white d-flex justify-content-center align-items-center mx-auto"
                                             style={{ width: "100px", height: "100px", fontSize: "2.5rem" }}>
                                            {student.firstName ? student.firstName.charAt(0).toUpperCase() : ""}
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="row mb-3">
                                <div className="col-md-6">
                                    <h5 className="text-muted">First Name</h5>
                                    <p className="fs-5">{student.firstName}</p>
                                </div>
                                <div className="col-md-6">
                                    <h5 className="text-muted">Last Name</h5>
                                    <p className="fs-5">{student.lastName}</p>
                                </div>
                            </div>

                            <div className="row mb-3">
                                <div className="col-md-6">
                                    <h5 className="text-muted">Email</h5>
                                    <p className="fs-5">{student.email}</p>
                                </div>
                                <div className="col-md-6">
                                    <h5 className="text-muted">Department</h5>
                                    <p className="fs-5">{student.department}</p>
                                </div>
                            </div>

                            <div className="row mb-3">
                                <div className="col-md-6">
                                    <h5 className="text-muted">Student ID</h5>
                                    <p className="fs-5">{id}</p>
                                </div>
                            </div>

                            <hr className="my-4" />

                            <div className="d-flex justify-content-between">
                                <Link to="/view-students" className="btn btn-outline-primary">
                                    <FaArrowLeft className="me-2" /> Back
                                </Link>
                                <Link to={`/edit-student/${id}`} className="btn btn-warning">
                                    <FaEdit className="me-2" /> Edit
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default StudentProfile;