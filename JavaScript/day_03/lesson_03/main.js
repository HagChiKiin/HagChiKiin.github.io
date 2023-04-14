  // 1. in ra thông tin các sản phẩm trong giỏ hàng
  function Product(products_name,products_price,products_brand,products_count) {
    this.name = products_name;
    this.price = products_price;
    this.brand = products_brand;
    this.count = products_count;
  }
  const product1 = new Product("Iphone 13 pro max", 30000000, "Apple", 2);
  const product2 = new Product("Samsung Galaxy Z Fold3", 41000000, "Samsung", 1);
  const product3 = new Product("Iphone 11", 15500000, "Apple", 1);
  const product4 = new Product("OPPO Find X3 Pro", 19500000, "OPPO", 3);
  let products = [product1, product2, product3, product4];
  function print_product_list(product_arr) {
    for (product of product_arr)
      console.log(
        `     ${product.name} - ${product.price} - ${product.brand} - ${product.count}`
      );
  }

  //1
  console.log(`1. Product Infomation`);
  print_product_list(products);

  //2
  function total_price(product_list) {
    return product_list.reduce(
      (total_price, element) => total_price + element.price * element.count,0);
  }
  console.log(`2. Total price: ${total_price(products)}`);

  //3
  function filter_by_brand(product_list, brand) {
    return product_list.filter((products) => products.brand === brand);
  }
  console.log("3. List product of Apple: ");
  print_product_list(filter_by_brand(products, "Apple"));

  //4
  function filter_by_price(product_list, price) {
    return product_list.filter((element) => element.price > price);
  }
  console.log("4. List product have price is bigger than 20000000");
  print_product_list(filter_by_price(products, 20000000));

  //5
  function filter_by_name(product_list, subStr) {
    return product_list.filter((element) => element.name.toLowerCase().includes(subStr.toLowerCase()));
  }
  console.log("5. List product have name contain 'pro'");
  print_product_list(filter_by_name(products, "pro"));

  //6
  function add_element(product_list, product_item) {
    product_list.push(product_item);
    return product_list;
  }
  console.log("6.List products after adding product 5");
  print_product_list(add_element(products,new Product("Xiaomi Mi 12", 25000000, "Xiaomi", 2)));

  //7
  function remove_by_brand(product_list, brand) {
    return product_list.filter((element) => element.brand.toLowerCase() !== brand.toLowerCase());
  }
  console.log("7.List products after delete brand Samsung");
  print_product_list(remove_by_brand(products, "Samsung"))

  //8
  function sort_by_price_asc(product_list){
    return product_list.sort((a, b) => a.price - b.price);
  }
  console.log("8.List products after sort by price asc");
  print_product_list(sort_by_price_asc(products))

  //9
  function sort_by_count_desc(product_list){
    return product_list.sort((a, b) => b.count - a.count);
  }
  console.log("9.List products after sort by count desc");
  print_product_list(sort_by_count_desc(products))


  //10
  function get_random_products(product_list, num) {
    return product_list.sort(() => 0.5 - Math.random()).slice(0, num);
  }
  console.log("10.List products after take out any 2 products");
  print_product_list(get_random_products(products,2))
