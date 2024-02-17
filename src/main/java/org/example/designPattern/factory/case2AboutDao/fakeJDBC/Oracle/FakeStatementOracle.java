package org.example.designPattern.factory.case2AboutDao.fakeJDBC.Oracle;

import org.example.designPattern.factory.case2AboutDao.fakeJDBC.mysql.AppConfig;
import org.example.designPattern.factory.case2AboutDao.fakeJDBC.TestConnectionException;

import java.sql.*;

public class FakeStatementOracle implements Statement {

    protected FakeStatementOracle(){}
    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        AppConfig 의존성주입_해주는_놈 = new AppConfig();
        return 의존성주입_해주는_놈.getResultSet();
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void close() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void cancel() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getUpdateCount() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getResultSetType() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void clearBatch() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int[] executeBatch() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public Connection getConnection() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean isPoolable() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new TestConnectionException("지원하지 않는 쿼리입니다. 테스트에 사용하고 싶으면 FakeStatement 클래스를 수정해주세요", Thread.currentThread().getStackTrace().toString());
    }
}
