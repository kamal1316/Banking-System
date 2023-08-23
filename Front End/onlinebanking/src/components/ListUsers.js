import Table from 'react-bootstrap/Table';

function ListUsers() {
  return (
    <Table All Listed Users>
      <thead>
        <tr>
          <th>User ID</th>
          <th>Name</th>
          <th>Account Number</th>
          <th>Active Status</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>4001</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>Active</td>
        </tr>
        
      </tbody>
    </Table>
  );
}

export default ListUsers;