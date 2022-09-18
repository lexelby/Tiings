package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_69a
   extends TilingType
{
   public TilingTypeNC5_69a(){
      super( "NC5-69a", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50,  0};
      paramName = new String[]{ "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,3,4, 1},
            {1, 0,2, 0,5,4, 0},
            {0, 3,4, 2,3,4, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 3,4, 4,3,4, 1},
            {1, 0,2, 4,5,4, 0},
            {0, 3,4, 6,3,4, 1},
      };
      info = "a=c\nb=2e\nA=30\nB=150\nC=60\nD=90\n(E=210)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3)/2;
      double ln1 = paramValues[0]/100.;
      double ln2 = 1-ln1;
      double os = ln2*2 * getParam( paramValues,1)/100.;

      baseTile.setPoint(0, 0,           0);
      baseTile.setPoint(1, os,          0);
      baseTile.setPoint(2, 2*ln2,       0);
      baseTile.setPoint(3, ln1*h+2*ln2, ln1/2);
      baseTile.setPoint(4, ln1*h+ln2/2, ln1/2+ln2*h);
      baseTile.setPoint(5, ln1*h,       ln1/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(1);
   }
}
