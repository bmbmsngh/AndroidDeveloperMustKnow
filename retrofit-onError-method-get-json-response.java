public void onError(Throwable e) {
        if (e instanceof HttpException) {
            ResponseBody body = ((HttpException) e).response().errorBody();
            BufferedReader reader = null;
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(body.byteStream()));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                String finallyError = sb.toString();
                JSONObject jsonObject = new JSONObject(finallyError);
                Log.d(TAG, "jsonObject : " + jsonObject);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            e.printStackTrace();
        }
    }
