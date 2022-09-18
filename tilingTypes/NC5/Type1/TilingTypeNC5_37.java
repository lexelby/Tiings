package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_37
   extends TilingType
{
   public TilingTypeNC5_37(){
      super( "NC5-37", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 45};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,3,4, 1},
            {0, 2,3, 0,3,2, 0},
            {1, 3,4, 2,3,4, 1},
            
            {0, 4,0, 1,1,0, 1},
            {1, 3,4, 4,3,4, 0},
            {0, 2,3, 4,3,2, 1},
            {1, 3,4, 6,3,4, 0},
      };
      info = "b=a+d\nB+C=360\nA=90\nB=2D\n(D+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double d = getParam( paramValues,0);
      double diag = 3 * Math.sin(d * DEG2RAD);
      double diag2 = diag/Math.sin((45-d) * DEG2RAD);
      double ln2 = diag2/Math.sqrt(2);
      double ln1 = 1;
      
      double scale = 1.2 / (ln2+1);
      ln2*=scale;
      ln1*=scale;
      
      double x2 = ln1+ln2-ln1*Math.cos( (d+d) * DEG2RAD);
      double y2 =         ln1*Math.sin( (d+d) * DEG2RAD);
      double x3 = x2+ln1;
      double y3 = y2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1+ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0,  ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[4].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(4);
   }
}
