package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_72d
   extends TilingType
{
   public TilingTypeNC5_72d(){
      super( "NC5-72d", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };
      // 90.0 63.43 153.43 206.57 26.57

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 0,4, 0,3,4, 0},
            {1, 0,1, 0,1,0, 0},
            {1, 4,3, 2,3,4, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 0,4, 4,3,4, 0},
      };
      info = "a=e\nb+d=2a\nA=90\nD=90\nE=90\n(B=45)\n(C=225)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double f = ln1 * paramValues[0]/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1*2-f, 0);
      baseTile.setPoint(2,ln1,  ln1-f);
      baseTile.setPoint(3,ln1,  ln1);
      baseTile.setPoint(4,  0,  ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[1].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[1].getY(1)-tiles[5].getY(2);
   }
}
