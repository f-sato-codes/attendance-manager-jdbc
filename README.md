# attendance-manager-jdbc

Java + MySQL + JDBC で作成した勤怠管理コンソールアプリです。
入社前学習として、JDBCによるDB接続、2テーブル構成、外部キー、JOIN、Repository分離を理解する目的で作成しています。

## 使用技術

* Java
* MySQL
* JDBC
* MySQL Connector/J
* Eclipse
* Git / GitHub

## 現在実装済みの機能

* 社員一覧表示
* 勤怠登録
* 社員名つき勤怠一覧表示
* 社員別勤怠一覧表示

## DB構成

### employees

社員情報を管理するテーブルです。

| カラム名       | 内容   |
| ---------- | ---- |
| id         | 社員ID |
| name       | 社員名  |
| department | 部署名  |
| status     | 在籍状態 |

### daily_attendances

勤怠情報を管理するテーブルです。

| カラム名        | 内容   |
| ----------- | ---- |
| id          | 勤怠ID |
| employee_id | 社員ID |
| work_date   | 勤務日  |
| start_time  | 出勤時刻 |
| end_time    | 退勤時刻 |
| status      | 勤怠状態 |

`daily_attendances.employee_id` は `employees.id` を参照する外部キーです。

## クラス構成

### Main

アプリの実行クラスです。
Repositoryを呼び出し、取得したデータをコンソールに表示します。

### Employee

`employees` テーブル1行分を表すクラスです。

### Attendance

`daily_attendances` テーブル1行分を表すクラスです。

### AttendanceDetail

`daily_attendances` と `employees` をJOINした結果1行分を表すクラスです。
社員名や部署名を含む勤怠一覧表示で使用します。

## Repository構成

### EmployeeRepository

社員データ操作のルールを定義するinterfaceです。

### JdbcEmployeeRepository

`EmployeeRepository` を実装するクラスです。
JDBCを使って `employees` テーブルを操作します。

### AttendanceRepository

勤怠データ操作のルールを定義するinterfaceです。

現在定義している主なメソッド：

* `insert`
* `findAllWithEmployee`
* `findByEmployeeId`

### JdbcAttendanceRepository

`AttendanceRepository` を実装するクラスです。
JDBCを使って `daily_attendances` テーブルを操作します。
JOINを使った社員名つき勤怠一覧の取得もこのクラスで行います。

## 設計で意識したこと

このアプリでは、役割を分けて実装しています。

* Main：画面表示とRepository呼び出し
* Repository interface：できることの約束
* JdbcRepository：SQLを使った実際のDB操作
* Entity / Detailクラス：DBから取得したデータの入れ物

`Attendance` は勤怠テーブルそのものを表します。
`AttendanceDetail` はJOIN結果を表示するための専用クラスです。

## JDBCで学習したこと

* `Connection` でDBへ接続する
* `Statement` で条件なしSELECTを実行する
* `PreparedStatement` で条件ありSQLやINSERTを実行する
* `executeQuery()` でSELECTを実行する
* `executeUpdate()` でINSERT / UPDATE / DELETEを実行する
* `ResultSet` から値を取り出す
* `ResultSet.next()` で1行ずつ処理する
* `LocalDate` / `LocalTime` と SQLの `date` / `time` を変換する
* JOIN結果を専用クラスに詰めて扱う

## DB接続情報について

DB接続情報は学習用です。
実務ではユーザー名やパスワードをソースコードに直接書かず、環境変数や設定ファイルで管理します。
