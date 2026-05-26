package com.yogita.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/bfhl")
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> processData(@RequestBody RequestDTO request) {

        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;
        StringBuilder allAlphabets = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int number = Integer.parseInt(item);

                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());
                allAlphabets.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        String concatString = buildConcatString(allAlphabets.toString());

        ResponseDTO response = new ResponseDTO();

        response.setIs_success(true);
        response.setUser_id("yogita_gurjar_15082006");
        response.setEmail("yogitagurjar230840@acropolis.in");
        response.setRoll_number("0827CD231078");

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatString);

        return ResponseEntity.ok(response);
    }

    private String buildConcatString(String input) {

        String reversed = new StringBuilder(input).reverse().toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}

class RequestDTO {

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

class ResponseDTO {

    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;

    private List<String> odd_numbers;
    private List<String> even_numbers;
    private List<String> alphabets;
    private List<String> special_characters;

    private String sum;
    private String concat_string;

    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public List<String> getOdd_numbers() {
        return odd_numbers;
    }

    public void setOdd_numbers(List<String> odd_numbers) {
        this.odd_numbers = odd_numbers;
    }

    public List<String> getEven_numbers() {
        return even_numbers;
    }

    public void setEven_numbers(List<String> even_numbers) {
        this.even_numbers = even_numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getSpecial_characters() {
        return special_characters;
    }

    public void setSpecial_characters(List<String> special_characters) {
        this.special_characters = special_characters;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getConcat_string() {
        return concat_string;
    }

    public void setConcat_string(String concat_string) {
        this.concat_string = concat_string;
    }
}
