// © Daniel Mesham 2018

package com.danmesh.runreview;

/**
 * 
 * @author Dan
 */
public class TrackView extends javax.swing.JFrame {

    private final Track track;
    
    public TrackView(Track trackToView) {
        this.track = trackToView;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        scrollPanePanel = new javax.swing.JPanel();
        mapPanel = new com.danmesh.runreview.MapPanel(track);
        titlePanel = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        distanceLabel = new javax.swing.JLabel();
        paceLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        actionButtonPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        showLapTableButton = new javax.swing.JButton();
        showLapTableButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RunReview");
        setMaximumSize(new java.awt.Dimension(954, 667));
        setMinimumSize(new java.awt.Dimension(954, 667));

        mainScrollPane.setBorder(null);
        mainScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setFont(new java.awt.Font("Lucida Grande", 2, 18)); // NOI18N
        dateLabel.setText(track.getDateString());

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titleLabel.setText(track.getDayOfWeek() + " Run");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(659, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel)
                .addGap(10, 10, 10)
                .addComponent(dateLabel)
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Time");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Distance");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("Pace");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("Calories");

        timeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        timeLabel.setText(Track.timeToString(track.getTimerTime(), false, true));

        distanceLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        distanceLabel.setText(String.format("%.2f", track.getDistance()/1000.0) + " km");

        paceLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        paceLabel.setText(track.getPaceString() + " min/km");

        caloriesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        caloriesLabel.setText(track.getCalories() + " C");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caloriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        infoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(timeLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(distanceLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(paceLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(caloriesLabel))
                .addGap(20, 20, 20))
        );

        actionButtonPanel.setPreferredSize(new java.awt.Dimension(226, 138));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Select an action:");

        showLapTableButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        showLapTableButton.setText("Show laps");
        showLapTableButton.setEnabled(false);
        showLapTableButton.setPreferredSize(new java.awt.Dimension(100, 33));
        showLapTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLapTableButtonActionPerformed(evt);
            }
        });

        showLapTableButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        showLapTableButton1.setText("Show lap time graph");
        showLapTableButton1.setEnabled(false);
        showLapTableButton1.setPreferredSize(new java.awt.Dimension(100, 33));
        showLapTableButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLapTableButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionButtonPanelLayout = new javax.swing.GroupLayout(actionButtonPanel);
        actionButtonPanel.setLayout(actionButtonPanelLayout);
        actionButtonPanelLayout.setHorizontalGroup(
            actionButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionButtonPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(actionButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(showLapTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(showLapTableButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        actionButtonPanelLayout.setVerticalGroup(
            actionButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionButtonPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(showLapTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showLapTableButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout scrollPanePanelLayout = new javax.swing.GroupLayout(scrollPanePanel);
        scrollPanePanel.setLayout(scrollPanePanelLayout);
        scrollPanePanelLayout.setHorizontalGroup(
            scrollPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(scrollPanePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(scrollPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        scrollPanePanelLayout.setVerticalGroup(
            scrollPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollPanePanelLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(scrollPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(scrollPanePanelLayout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        mainScrollPane.setViewportView(scrollPanePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showLapTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLapTableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showLapTableButtonActionPerformed

    private void showLapTableButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLapTableButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showLapTableButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionButtonPanel;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel distanceLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane mainScrollPane;
    private com.danmesh.runreview.MapPanel mapPanel;
    private javax.swing.JLabel paceLabel;
    private javax.swing.JPanel scrollPanePanel;
    private javax.swing.JButton showLapTableButton;
    private javax.swing.JButton showLapTableButton1;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}
