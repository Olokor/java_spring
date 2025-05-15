import React, { useEffect, useState } from "react";
import axios from "axios";
import {FaEdit, FaEye, FaTrashAlt} from "react-icons/fa";
import {Link} from "react-router-dom";

const StudentView = () => {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        loadStudents();
    }, []);

    const loadStudents = async () => {
        try {
            const response = await axios.get("http://localhost:8080/students", {
                validateStatus: (status) => {
                    // Accept both successful responses (200-299) and 302 redirect
                    return (status >= 200 && status < 300) || status === 302;
                }
            });

            // Check if response contains data (302 might include data in your API)
            if (response.data) {
                setStudents(response.data);
            }
        } catch (error) {
            console.error("Error loading students:", error);
            // Handle error appropriately
        }
    };
    const handleDelete = async (id) => {
        await axios.delete(`http://localhost:8080/students/${id}`);
        loadStudents();
    }
    return (
        <section>
            <table className="table table-bordered table-hover shadow">
                <thead className="text-center">
                <tr>
                    <th>Serial number</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th colSpan='3'>Action</th>
                </tr>
                </thead>
                <tbody className="text-center">
                {students.map((student, index) => (
                    <tr key={student.id}>
                        <th scope="row">{index + 1}</th>
                        <td>{student.firstName}</td>
                        <td>{student.lastName}</td>
                        <td>{student.email}</td>
                        <td>{student.department}</td>
                        <td className="mx-2">
                            <Link to={`/student-profile/${student.id}`} className="btn btn-info"><FaEye/></Link>
                        </td>
                        <td className="mx-2">
                            <Link to={`/edit-student/${student.id}`} className="btn btn-warning"><FaEdit/></Link></td>
                        <td className="mx-2">
                            <button className="btn btn-danger" onClick={() => handleDelete(student.id)}><FaTrashAlt/></button></td>

                    </tr>
                    ))}
                </tbody>
            </table>
        </section>
    );
};

export default StudentView;