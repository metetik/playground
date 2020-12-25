import React, { Component } from "react";
import { Button,Table } from "reactstrap";

export default class ProductList extends Component {
  addToCart = (product) => {
    alert(product.productName);
  }
  render() {
    return (
      <Table>
        <thead>
          <tr>
            <th>Product ID</th>
            <th>Category ID</th>
            <th>Product Name</th>
            <th>Quantity per Unit</th>
            <th>Unit Price</th>
            <th>Unit in Stock</th>
          </tr>
        </thead>
        <tbody>
          {this.props.products.map(product => (
            <tr key={product.id}>
              <th scope="row">{product.id}</th>
              <td>{product.categoryId}</td>
              <td>{product.productName}</td>
              <td>{product.quantityPerUnit}</td>
              <td>{product.unitPrice}</td>
              <td>{product.unitsInStock}</td>
              <td><Button color="info" onClick={()=>this.addToCart(product)}>Ekle</Button></td>
            </tr>
          ))}
        </tbody>
      </Table>
    );
  }
}
